package com.yari.core;

import com.yari.api.Service;
import com.yari.files.FilesUtils;
import com.yari.injector.Injector;
import com.yari.network.NetworkModule;
import com.yari.network.api.NetworkService;
import org.json.JSONObject;

public class Main {

    public static void main(String[] args) throws Exception {
        Header.show();

        Injector injector = Injector.create();
        injector.bindConfiguration(new JSONObject(FilesUtils.readAll("configuration.json")));

        injector.bind(new NetworkModule());

        injector.annotatedBy(NetworkService.class, Service.class).forEach(Service::start);


    }
}
