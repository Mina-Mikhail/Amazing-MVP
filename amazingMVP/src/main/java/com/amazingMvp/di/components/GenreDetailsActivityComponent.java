/*
* Copyright (C) 2015 Pedro Paulo de Amorim
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.amazingMvp.di.components;

import com.amazingMvp.di.ActivityModule;
import com.amazingMvp.di.GenreDetailsModule;
import com.amazingMvp.di.scopes.ActivityScope;
import com.amazingMvp.ui.activity.SubGenreActivity;
import com.amazingMvp.ui.presenter.GenreDetailsPresenter;
import com.amazingmvprules.domain.interactors.GetGenreDetails;
import dagger.Component;

@ActivityScope @Component(dependencies = ApplicationComponent.class,
    modules = { ActivityModule.class, GenreDetailsModule.class })
public interface GenreDetailsActivityComponent {
  void inject(SubGenreActivity subGenreActivity);
  GenreDetailsPresenter getGenreDetailsPresenter();
  GetGenreDetails getGenreDetails();
}
