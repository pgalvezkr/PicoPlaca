package com.sb.picoplaca.presentation;

import com.sb.picoplaca.exceptions.PicoPlacaException;
import com.sb.picoplaca.services.PicoPlacaPredictor;
import com.sb.picoplaca.services.PicoPlacaPredictorImp;

public class AppClass {

	
	public static void main(String[] args) {
		PicoPlacaPredictor picoPlacaS = new PicoPlacaPredictorImp();
		try {
			picoPlacaS.predictor("PDF-3655", "08/04/2019", "19:29");
		} catch (PicoPlacaException e) {
			System.out.println(e.getMessage());
		}
	}

}
