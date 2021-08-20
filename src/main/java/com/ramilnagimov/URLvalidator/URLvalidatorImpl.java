package com.ramilnagimov.URLvalidator;

import org.apache.commons.validator.routines.UrlValidator;

public class URLvalidatorImpl implements URLvalidator {
    String url;

    public URLvalidatorImpl(String url) {
        this.url = url;
    }

    @Override
    public boolean validateURL(String url) {
        String[] schemes = {"http", "https"};
        UrlValidator urlValidator = new UrlValidator(schemes);
        return urlValidator.isValid(url);
    }
}
