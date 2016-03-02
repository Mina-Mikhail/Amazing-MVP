/*
* Copyright (C) 2016 Pedro Paulo de Amorim
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
package com.amazingmvp.di.components;

import com.amazingmvp.di.ActivityModule;
import com.amazingmvp.di.GenreModule;
import com.amazingmvp.di.scopes.ActivityScope;
import com.amazingmvp.ui.fragment.GenreFragment;
import com.amazingmvprules.presenter.GenrePresenter;
import com.amazingmvprules.domain.interactors.GetGenres;
import dagger.Component;

@SuppressWarnings("unused")
@ActivityScope @Component(dependencies = ApplicationComponent.class,
    modules = { ActivityModule.class, GenreModule.class })
public interface GenreFragmentComponent {
  void inject(GenreFragment genreFragment);
  GenrePresenter getPresenter();
  GetGenres getGenres();
}