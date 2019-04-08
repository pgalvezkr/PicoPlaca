package com.sb.picoplaca.test;

import org.junit.Test;

import com.sb.picoplaca.exceptions.PicoPlacaException;
import com.sb.picoplaca.services.PicoPlacaPredictor;
import com.sb.picoplaca.services.PicoPlacaPredictorImp;

public class TestPicoPlacaPredictor {

	@Test
	public void picoPlacaPredictor() {
		PicoPlacaPredictor picoPlacaS = new PicoPlacaPredictorImp();
		try {
			picoPlacaS.predictor("PDF-55", "08/04/2019", "15:59");
		} catch (PicoPlacaException e) {
			System.out.println(e.getMessage());
		}
	}

}
