/**
 * Copyright (C) 2013 - 2015 the enviroCar community
 *
 * This file is part of the enviroCar app.
 *
 * The enviroCar app is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The enviroCar app is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
 * Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with the enviroCar app. If not, see http://www.gnu.org/licenses/.
 */
package org.envirocar.remote.service;

import com.squareup.okhttp.ResponseBody;


import org.envirocar.core.entity.Track;

import java.util.List;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;
import retrofit.http.Query;
import rx.Observable;

/**
 * @author dewall
 */
public interface TrackService {

    @GET("users/{user}/tracks/{track}")
    Call<Track> getTrack(@Path("user") String user,
                         @Path("track") String track);

    @GET("users/{user}/tracks/{track}?limit=10000")
    Observable<Track> getTrackObservable(@Path("user") String user,
                                         @Path("track") String track);

    @GET("users/{user}/tracks/{track}?limit=100")
    Call<List<Track>> getTracks(@Path("user") String user,
                                @Path("track") String track);

    @GET("users/{user}/tracks/{track}?limit=100")
    Observable<List<Track>> getTracksObservable(@Path("user") String user,
                                                @Path("track") String track);

    @GET("users/{user}/tracks/{track}")
    Call<List<Track>> getTracks(@Path("user") String user,
                                @Path("track") String track,
                                @Query("limit") int pageSize);

    @GET("users/{user}/tracks/{track}")
    Observable<List<Track>> getTracksObservable(@Path("user") String user,
                                                @Path("track") String track,
                                                @Query("limit") int pageSize);

    @GET("users/{user}/tracks/")
    Call<List<Track>> getTrackIds(@Path("user") String user);

    @GET("tracks?limit=1")
    Call<ResponseBody> getAllTracksCount();

    @GET("users/{user}/tracks?limit=1")
    Call<ResponseBody> getAllTracksCountOfUser(@Path("user") String user);

    @POST("users/{user}/tracks/")
    Call<ResponseBody> uploadTrack(@Path("user") String user, @Body Track track);

    @DELETE("users/{user}/tracks/{track}")
    Call<ResponseBody> deleteTrack(@Path("user") String user, @Path("track") String track);


}

