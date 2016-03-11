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
import com.amazingmvp.di.HomeModule;
import com.amazingmvp.di.scopes.ActivityScope;
import com.amazingmvp.ui.activity.HomeActivity;
import com.amazingmvprules.domain.interactors.HomeInteractor;
import com.amazingmvprules.presenter.HomePresenter;
import dagger.Component;

@SuppressWarnings("unused")
@ActivityScope @Component(dependencies = ApplicationComponent.class,
    modules = { ActivityModule.class, HomeModule.class })
public interface HomeActivityComponent {
  void inject(HomeActivity homeActivity);
  HomePresenter getPresenter();
  HomeInteractor getGenres();
}
