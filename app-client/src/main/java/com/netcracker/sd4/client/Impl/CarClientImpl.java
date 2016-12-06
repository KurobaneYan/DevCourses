package com.netcracker.sd4.client.Impl;

import com.netcracker.sd4.client.CarClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CarClientImpl extends ClientImpl implements CarClient {
    @Override
    public <T> ResponseEntity<T> getCarsPagination(int page, int pageSize, Class<T> tClass) {
        String url = "http://localhost:8000/car/" + page + "/" + pageSize + "/";
        return processURL(url, HttpMethod.GET, tClass, null);
    }
}
