package com.github.watanabear.learndatabindingwithrecyclerview.api

import com.github.watanabear.learndatabindingwithrecyclerview.domain.Contributor
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by ryo on 2017/06/12.
 */
interface GithubService {
    @GET("/repos/{owner}/{repo}/contributors")
    fun fetchContributors(@Path("owner") owner: String,
                          @Path("repo") repo: String,
                          @Query("per_page") perPage: Int): Observable<List<Contributor>>
}