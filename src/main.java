import java.util.Date;

public class main {
	
	
	
	public static void main(String args[]) {
		
		//teste;
		Cliente cliente = new Cliente("Ariel", "12", "podecre...", "agcagc", "naomeliga");
		Endereco endereco = new Endereco("Rua minha rua", "199", "Casa carai", "Bairro meu bairro", "Hellgrete", "97546380", "RS", "Brazilian");
		Date date = new Date();
		Status status = Status.AGUARDANDO_PAGAMENTO;
		Pedido pedido = new Pedido("1717", endereco, date, 10.0 , status, cliente);
		
		System.out.println("Status: " + pedido.getStatus() + " Valor do status: " + pedido.printStatusInteger());
		
		pedido.setStatus(status.PEDIDO_PAGO);
		
		System.out.println("Status: " + pedido.getStatus() + " Valor do status: " + pedido.printStatusInteger());
		
		
		
	}
	
}
