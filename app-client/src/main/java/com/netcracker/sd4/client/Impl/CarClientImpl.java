package com.netcracker.sd4.client.Impl;

import com.netcracker.sd4.client.CarClient;
import com.netcracker.sd4.client.Link;
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

    @Override
    public <T> ResponseEntity<T> getDefaultCarsPagination(int page, Class<T> tClass) {
        return getCarsPagination(page, 10, tClass);
    }

    @Override
    public <T> ResponseEntity<T> searchCarWithPagination(String keyword, int page, int pageSize, Class<T> tClass) {
        return process(Link.SEARCH_CARS, tClass, null);
    }

    @Override
    public ResponseEntity<Long> getCarsCount() {
        return process(Link.GET_CARS_COUNT, Long.class, null);
    }
}
