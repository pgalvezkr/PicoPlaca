package com.sb.picoplaca.services;

import com.sb.picoplaca.exceptions.PicoPlacaException;

public interface PicoPlacaPredictor {

	boolean predictor(String placa, String date, String time)  throws PicoPlacaException;
}
