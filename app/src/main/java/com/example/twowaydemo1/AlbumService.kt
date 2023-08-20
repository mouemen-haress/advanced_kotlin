package com.example.twowaydemo1

import retrofit2.Response
import retrofit2.http.*

interface AlbumService {

    @GET("/albums")
    suspend fun getAlbums(): Response<Albums>

    @GET("/albums")
    suspend fun getSortedAlbumes(@Query("userId") userId: Int): Response<Albums>

    @GET("/albums/{id}")
    suspend fun getSortedAlbum(@Path("id") albumId: Int): Response<AlbumsItem>

    @POST("/albums")
    suspend fun uploadAlbum(@Body album:AlbumsItem): Response<AlbumsItem>
}