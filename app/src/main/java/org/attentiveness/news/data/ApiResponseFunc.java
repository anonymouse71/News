package org.attentiveness.news.data;


import org.attentiveness.news.exception.ApiException;

import rx.functions.Func1;

/**
 * Convert ApiResponse<T> to T.
 */
public class ApiResponseFunc<T> implements Func1<ApiResponse<T>, T> {

    @Override
    public T call(ApiResponse<T> response) {
        if (response.getCode() != 0) {
            throw new ApiException(response.getMessage());
        }
        return response.getObj();
    }
}