
public enum Status {
	AGUARDANDO_PAGAMENTO(0), PEDIDO_PAGO(1), PEDIDO_EM_SEPARACAO(2),
	PEDIDO_ENVIADO(3), PEDIDO_ENTREGUE(4), PEDIDO_CANCELADO(5);
	
	int status;
	
	Status(int status){
		this.status = status;
	}
	
	private int getStatus() {
		return this.status;
	}
	
}
