package fr.nantes.ustephan.world.validator;

import fr.nantes.ustephan.world.form.CityForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by ughostephan on 21/01/2017.
 */
@Component
public class CityFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return CityForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        CityForm form = (CityForm) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.cityForm.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "countryCode", "NotEmpty.cityForm.countryCode");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "district", "NotEmpty.cityForm.district");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "population", "NotEmpty.cityForm.population");

        if (form.getPopulation() != null && form.getPopulation() <= 0) {
            errors.rejectValue("population", "Min.cityForm.population");
        }
    }

}
