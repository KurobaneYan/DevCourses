package com.netcracker.sd4.client;

import org.springframework.http.ResponseEntity;

public interface CarClient extends Client {
    <T> ResponseEntity<T> getCarsPagination(int page, int pageSize, Class<T> tClass);
}
