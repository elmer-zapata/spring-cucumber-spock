import com.example.accessingmongodbdatarest.cliente.Client;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {
    @Given("el cliente realiza el pago con su tarjeta por un importe $monto_pago")
    public void elClienteRealizaElPagoConSuTarjetaPorUnImporte$monto_pago() {
//        Client client =new ClientBuilder().withTarget();
    }

    @When("el comercio otorga un descuento de $porcentaje_descuento durante el registro de cobro en el POS")
    public void elComercioOtorgaUnDescuentoDe$porcentaje_descuentoDuranteElRegistroDeCobroEnElPOS() {

//        Comercio comercio= new Comercio();
    }

    @Then("el comercio otorga un $descuento como beneficio al cliente")
    public void elComercioOtorgaUn$descuentoComoBeneficioAlCliente() {

    }


    Client client;

    @And("soy un cliente planilla con tarjeta numero xxx asociado a una cuenta en bs")
    public void soyUnClientePlanillaConTarjetaNumeroXxxAsociadoAUnaCuentaEnBs(String typeAccount) {
//        client = new ClientBuilder().withTarget("xxx").withAccount(typeAccount);
    }
}
