package aplication;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import FicticiusClean.DataHolder;
import Veiculos.VeiculoInput;
import Veiculos.VeiculosManagement;


@Path("/")
public class VeiculoService {
 @GET
 @Produces(MediaType.APPLICATION_JSON)
 @Path("/getLista")
 public String getLista(@PathParam("preco") String paramPreco, @PathParam("kmCidade") String paramKmCidade, @PathParam("kmEstrada") String paramKmEstrada) {
	 int kmCidade = 0;
	 int kmEstrada = 0;
	 Double preco = 0.00;
	 
		try {
			kmCidade = Integer.parseInt(paramKmCidade);
			kmEstrada = Integer.parseInt(paramKmEstrada);
		} catch(Exception e) {
			   throw new WebApplicationException(Response
					     .status(Response.Status.BAD_REQUEST)
					     .entity("Os kilometros rodados esta(ão) em formato incorreto, esperado Inteiro").build());
		}	
		try {
			preco = Double.parseDouble(paramPreco.replace(",", "."));
		} catch(Exception e) {
			   throw new WebApplicationException(Response
					     .status(Response.Status.BAD_REQUEST)
					     .entity("O preço deve ser informado no formato decimal(0.00)").build());
		}
		return new VeiculosManagement().calculaMelhorCusto(preco, kmCidade, kmEstrada);
 
 }
 @POST
 @Consumes(MediaType.APPLICATION_JSON)
 @Produces(MediaType.APPLICATION_JSON)
 @Path("/cadastroVeiculo")
 public Response novoVeiculo(String paramNome,String paramMarca,String paramModelo,String paramDataFabricacao,String paramConsumoCidade,String paramConsumoEstrada) {
 	DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
 	Date data = null;
 	Double consumoCidade = 0.00;
 	Double consumoEstrada = 0.00;
 	
 	if(Utils.validaString(paramNome) && Utils.validaString(paramMarca) && Utils.validaString(paramModelo) && Utils.validaString(paramDataFabricacao) && Utils.validaString(paramConsumoCidade) && Utils.validaString(paramConsumoEstrada)) {
 		try {
 			data = (Date)formatter.parse(paramDataFabricacao);
 		} catch (ParseException e) {
 			throw new WebApplicationException(Response
 				     .status(Response.Status.BAD_REQUEST)
 				     .entity("Verifique o formato da data, esperado dd/mm/yyyy").build());
 		}
 		
 		try {
 			consumoCidade = Double.parseDouble(paramConsumoCidade.replace(",", "."));
 			consumoEstrada = Double.parseDouble(paramConsumoEstrada.replace(",", "."));
 		} catch (Exception e) {
 			throw new WebApplicationException(Response
 				     .status(Response.Status.BAD_REQUEST)
 				     .entity("O formato do consumo deve ser decimal(0.00)").build());
 		}
 		DataHolder.save(new VeiculoInput(paramNome,paramMarca,paramModelo,data,consumoCidade,consumoEstrada));
 	}else {
			throw new WebApplicationException(Response
				     .status(Response.Status.BAD_REQUEST)
				     .entity("Todos os campos são obrigatórios").build());
 	}


  return Response.status(Response.Status.OK).entity("Veiculo Cadastrado com Sucesso").build();
 }
}
