package br.com.sge.curso.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	

	/**
	 * Retorna idade formatada e.: 18 Anos, 2 meses e 28 dias
	 * @param data
	 * @return String data formatada
	 */
	public static String calcularIdadeFormatada(Date data) {
	        
		Calendar dataAtual = Calendar.getInstance();
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.setTime(data);
		Integer anos = (dataAtual.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR));
		Integer meses = (dataAtual.get(Calendar.MONTH) - dataNascimento.get(Calendar.MONTH));
		Integer dias = (dataAtual.get(Calendar.DAY_OF_MONTH) - dataNascimento.get(Calendar.DAY_OF_MONTH));
	
		if (dataAtual.get(Calendar.MONTH) == dataNascimento.get(Calendar.MONTH)) {
			if (dataAtual.get(Calendar.DAY_OF_MONTH) < dataNascimento.get(Calendar.DAY_OF_MONTH)) {
				dias = 30 + dias;
				meses = 12 + meses;
				anos = anos - 1;
			}
		} else if (dataAtual.get(Calendar.MONTH) < dataNascimento.get(Calendar.MONTH)) {
			if (dataAtual.get(Calendar.DAY_OF_MONTH) >= dataNascimento.get(Calendar.DAY_OF_MONTH)) {
				meses = 12 + meses;
				anos = anos - 1;
			} else if (dataAtual.get(Calendar.DAY_OF_MONTH) < dataNascimento.get(Calendar.DAY_OF_MONTH)) {
				dias = 30 + dias;
				meses = 12 + meses;
				anos = anos - 1;
			}
		} else if (dataAtual.get(Calendar.MONTH) > dataNascimento.get(Calendar.MONTH)) {
			if (dataAtual.get(Calendar.DAY_OF_MONTH) < dataNascimento.get(Calendar.DAY_OF_MONTH)) {
				dias = 30 + dias;
				meses = meses - 1;
			}
		}
		return formatar(anos, meses, dias);
	}
    /** Método responsável por formatar uma idade no formato 1 10 6.
     *  Concatena-se 0 se o valor menor que 10 e logo apos o numero adicionasse espaço.
     * 
     *  @return Data formatada para o formato 00 00 00.
     */
    public static String formatar(Integer ano, Integer mes, Integer dia) {
        String idade = "";
        if (ano < 10) {
            idade = idade + "0" + ano + " ";
        } else {
            idade = idade + ano + " ";
        }
        if (mes < 10) {
            idade = idade + "0" + mes + " ";
        } else {
            idade = idade + mes + " ";
        }
        if (dia < 10) {
            idade = idade + "0" + dia + " ";
        } else {
            idade = idade + dia + " ";
        }
        return formatarIdade(idade);
    }
    /** Pega os valores 00 00 00 e coloca Ano(s) Mes(es) Dia(s)
    */
    public static String formatarIdade(String str) {
        String idade = "";
        String CharArray[] = str.split(" ");
        String anos = CharArray[0];
        String meses = CharArray[1];
        String dias = CharArray[2];
        if (!anos.equals("00")) {
            if (anos.equals("01")) {
                idade = idade + anos + " Ano ";
            } else {
                idade = idade + anos + " Anos ";
            }
        }
        if (!meses.equals("00")) {
            if (meses.equals("01")) {
                idade = ", " + idade + meses + " meses ";
            } else {
                idade = ", " + idade + meses + " meses ";
            }
        }
        if (!dias.equals("00")) {
            if (dias.equals("01")) {
                idade = "e " + idade + dias + " dia ";
            } else {
                idade = "e " + idade + dias + " dias";
            }
        }
        return idade;
    }
}
