package com.stefanini.desafio.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Util {

    public static boolean verificarDataAnterior( LocalDate dataInicio, LocalDate dataFim ){
        if( dataInicio.isBefore( dataFim ) ){
            return true;
        } else {
            return false;
        }
    }

    public static long diffEntreData( LocalDate dataInicio, LocalDate dataFim ){
       return ChronoUnit.DAYS.between( dataInicio, dataFim );
    }

    public static int qtdFimDeSemana( LocalDate dataInicio, long periodo ){
        int qtdFimDeSemana = 0;

        for (int i = 1; i <= periodo; i++){
            dataInicio.plusDays( i );
            if ( fimDeSemana(dataInicio) ){
                qtdFimDeSemana++;
            }
        }

        return  qtdFimDeSemana;
    }

    public static boolean fimDeSemana( LocalDate ld ) {
        DayOfWeek d = ld.getDayOfWeek();
        return d == DayOfWeek.SATURDAY || d == DayOfWeek.SUNDAY;
    }

    public static LocalDate retornaLocalDate(String data) {

//        data = aaaa-mm-dd
        String[] split = data.split("-");
        LocalDate localDate = LocalDate.of( Integer.valueOf(split[0]),Integer.valueOf(split[1]),Integer.valueOf(split[2]) );
        return localDate;
    }

    public static String formatarCPF(String cpf)    {
        if ( !cpf.contains(".") ) {
            return (cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." +
                    cpf.substring(6, 9) + "-" + cpf.substring(9, 11));
        }
        return cpf;
    }

}
