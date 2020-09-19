package com.simuladorfinanciamento;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import com.simuladorfinanciamento.DTO.SimuladorEmprestimoDTO;
import com.simuladorfinanciamento.entity.Cliente;
import com.simuladorfinanciamento.entity.ContratarEmprestimo;
import com.simuladorfinanciamento.entity.ParcelaEmprestimo;
import com.simuladorfinanciamento.entity.SimuladorEmprestimo;
import com.simuladorfinanciamento.repository.ClienteRepository;
import com.simuladorfinanciamento.service.EmprestimoService;
import org.assertj.core.api.Assertions;


@ContextConfiguration
public class SimuladorEmprestimoTeste {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EmprestimoService emprestimoService;
	
	@Test
	public void saveTest() {
		ParcelaEmprestimo parcelaEmprestimo = new ParcelaEmprestimo(3, new BigDecimal("333"), new Date());
		ContratarEmprestimo contratarEmprestimo = new ContratarEmprestimo(new Date(), new BigDecimal("300"), new BigDecimal("8"), new BigDecimal("3"), new BigDecimal("2"), parcelaEmprestimo);
		SimuladorEmprestimo simuladorEmprestimo = new SimuladorEmprestimo(new Date(), new Date(), new BigDecimal("3000"), new BigDecimal("8"), new BigDecimal("780"), new BigDecimal("3"), contratarEmprestimo);
		Cliente cliente = new Cliente(new BigDecimal("222"),"leiton","testse", simuladorEmprestimo);
		Cliente salvo = this.clienteRepository.save(cliente);
		assertNotNull(salvo);
	}
	
	@Test
	public void SimuladorEmprestimoteste() throws ParseException {
		Cliente cliente = new Cliente(new BigDecimal("32"), "teste", "teste@.com", null);
		SimuladorEmprestimo emprestimoSimulado = emprestimoService.calcularEmprestimo(new BigDecimal("3000"), new BigDecimal("8"), cliente);
		assertNotNull(emprestimoSimulado);
	}
	
	@Test
	public void calcularValorParcelaTeste() {
		BigDecimal parcela = emprestimoService.caucularValorParcela(new BigDecimal("800"), new BigDecimal("3"));
		Assertions.assertThat(parcela).isEqualTo(new BigDecimal("218.066"));
	}
	
	@Test
	public void criarClienteTeste() throws ParseException {
		SimuladorEmprestimoDTO dto = new SimuladorEmprestimoDTO("Teste", "09500003619", "teste@teste.com", new BigDecimal("3000"),"8");
		Cliente cliente = emprestimoService.criarCiente(dto);
		assertNotNull(cliente);
	}
	
	@Test
	public void simularTeste() throws ParseException {
		SimuladorEmprestimoDTO dto = new SimuladorEmprestimoDTO("Teste", "09500003619", "teste@teste.com", new BigDecimal("3000"),"8");
		Object obj = emprestimoService.simular(dto);
		assertNotNull(obj);
	}
	
	@Test
	public void taxaJurosTeste0035() {
		Double juros = emprestimoService.taxaDeJuros(new BigDecimal("3000"), new BigDecimal("12"));
		Assertions.assertThat(juros).isEqualTo(0.035);
	}
	
	@Test
	public void taxaJurosTeste0018() {
		Double juros = emprestimoService.taxaDeJuros(new BigDecimal("800"), new BigDecimal("4"));
		Assertions.assertThat(juros).isEqualTo(0.018);
	}
	
	@Test
	public void taxaJurosTeste0023() {
		Double juros = emprestimoService.taxaDeJuros(new BigDecimal("800"), new BigDecimal("13"));
		Assertions.assertThat(juros).isEqualTo(0.023);
	}
	
	@Test
	public void validaPayLoadNumeraParcelaTeste() {
		SimuladorEmprestimoDTO dto = new SimuladorEmprestimoDTO("Teste", "09500003619", "teste@teste.com", new BigDecimal("3000"),"28");
		String msg = emprestimoService.validaPayLoad(dto);
		Assertions.assertThat(msg).isEqualTo("O número máximo de parcelas é 24");
	}
	
	@Test
	public void validaPayLoadEmailTeste() {
		SimuladorEmprestimoDTO dto = new SimuladorEmprestimoDTO("Teste", "09500003619", "teste@teste", new BigDecimal("3000"),"8");
		String msg = emprestimoService.validaPayLoad(dto);
		Assertions.assertThat(msg).isEqualTo("EMAIL invalido!");
	}
	
	@Test
	public void validaPayLoadCPFTeste() {
		SimuladorEmprestimoDTO dto = new SimuladorEmprestimoDTO("Teste", "11122233344", "teste@teste.com", new BigDecimal("3000"),"8");
		String msg = emprestimoService.validaPayLoad(dto);
		Assertions.assertThat(msg).isEqualTo("CPF inválido!");
	}
}
