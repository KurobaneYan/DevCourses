package com.netcracker.sd4.client;

import org.springframework.http.ResponseEntity;

public interface CarClient extends Client {
    <T> ResponseEntity<T> getCarsPagination(int page, int pageSize, Class<T> tClass);
    <T> ResponseEntity<T> getDefaultCarsPagination(int page, Class<T> tClass);
    <T> ResponseEntity<T> searchCarWithPagination(String keyword, int page, int pageSize, Class<T> tClass);
    ResponseEntity<Long> getCarsCount();
}
