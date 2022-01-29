package pl.tm.hardwareinventory.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.tm.hardwareinventory.model.Company;
import pl.tm.hardwareinventory.repository.CompanyRepository;

public class CompanyConverter implements Converter<String, Company> {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public Company convert(String source) {
        return companyRepository.findById(Long.parseLong(source)).orElseThrow(() -> new IllegalArgumentException(""));
    }
}
