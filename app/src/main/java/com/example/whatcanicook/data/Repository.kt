package com.example.whatcanicook.data

import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class Repository @Inject constructor(
    remoteDataSource: RemoteDataSource
) {

    val remote = remoteDataSource

}

/*with "@Inject constructor" we tell Hilt how to provide instances of Repository class- and its methods*/