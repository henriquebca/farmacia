package br.com.farmacia.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.farmacia.model.Produto;

@SpringBootTest
public class ProdutoTests {
	@Test
	public void criar() {
		Produto p1 = new Produto(
				Integer.valueOf("1"),
				"Coca Cola",
				Byte.valueOf("15"),
				BigDecimal.valueOf(10.50),
				LocalDate.of(2021, 11, 23),
				null
				);
	}

}
