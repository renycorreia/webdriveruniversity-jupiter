package wdu.utils;

import com.github.javafaker.Faker;
import wdu.domain.Pessoa;

import java.text.Normalizer;
import java.util.Locale;

public class GenericsUtils {

    public static Faker faker = new Faker(new Locale("pt_BR"));

    public static Pessoa pessoa()
    {
        Pessoa pessoa = new Pessoa();

        pessoa.setPrimeiroNome(faker.name().firstName());
        pessoa.setUltimoNome(faker.name().lastName());
        pessoa.setEmail(trataEmail(pessoa.getPrimeiroNome()+"."+pessoa.getUltimoNome())+"@mail.com");

        return pessoa;
    }

    public static String trataEmail(String str) {
        str = str.replaceAll("\\s+","").replaceAll("\\.","").toLowerCase();

        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }
}
