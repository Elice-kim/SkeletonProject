package com.rxandroid.elice.skeletonpj.data.repository;

import com.rxandroid.elice.skeletonpj.data.dto.DaumImageDTO;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by elice.kim on 2017. 7. 15..
 */

public interface ImageRepository {

    @GET("image?apikey=68bb419bdb007bd752defe7dfcddbd21&q=카카오&output=json")
    Observable<DaumImageDTO> getImageList();
}
