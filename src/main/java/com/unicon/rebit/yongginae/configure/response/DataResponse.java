package com.unicon.rebit.yongginae.configure.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DataResponse<T> extends CommonResponse{
    private T Result;
}
