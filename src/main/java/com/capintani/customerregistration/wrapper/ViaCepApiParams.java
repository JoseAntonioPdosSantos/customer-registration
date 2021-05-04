package com.capintani.customerregistration.wrapper;

public final class ViaCepApiParams extends RestTemplateParams {

    private static final String SCHEMA = "http";
    private static final String HOST = "viacep.com.br/ws";

    public ViaCepApiParams(final String path) {
        super(SCHEMA, HOST, path + "/json/");
    }
}
