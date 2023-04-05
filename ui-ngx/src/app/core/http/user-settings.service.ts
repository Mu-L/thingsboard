///
/// Copyright © 2016-2023 The Thingsboard Authors
///
/// Licensed under the Apache License, Version 2.0 (the "License");
/// you may not use this file except in compliance with the License.
/// You may obtain a copy of the License at
///
///     http://www.apache.org/licenses/LICENSE-2.0
///
/// Unless required by applicable law or agreed to in writing, software
/// distributed under the License is distributed on an "AS IS" BASIS,
/// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
/// See the License for the specific language governing permissions and
/// limitations under the License.
///

import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {
  DocumentationLink, DocumentationLinks,
  initialUserSettings,
  UserSettings,
  UserSettingsType
} from '@shared/models/user-settings.models';
import { map } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { defaultHttpOptionsFromConfig, RequestConfig } from '@core/http/http-utils';

@Injectable({
  providedIn: 'root'
})
export class UserSettingsService {

  constructor(
    private http: HttpClient
  ) {}

  public loadUserSettings(): Observable<UserSettings> {
    return this.http.get<UserSettings>('/api/user/settings', defaultHttpOptionsFromConfig({ignoreLoading: true, ignoreErrors: true})).pipe(
      map((settings) => (!settings || !Object.keys(settings).length) ? initialUserSettings : settings)
    );
  }

  public saveUserSettings(userSettings: UserSettings): Observable<UserSettings> {
    return this.http.post<UserSettings>('/api/user/settings', userSettings,
      defaultHttpOptionsFromConfig({ignoreLoading: true, ignoreErrors: true}));
  }

  public putUserSettings(userSettingsData: Partial<UserSettings>): Observable<void> {
    return this.http.put<void>('/api/user/settings', userSettingsData,
      defaultHttpOptionsFromConfig({ignoreLoading: true, ignoreErrors: true}));
  }

  public deleteUserSettings(paths: string[]) {
    return this.http.delete(`/api/user/settings/${paths.join(',')}`,
      defaultHttpOptionsFromConfig({ignoreLoading: true, ignoreErrors: true}));
  }

  public getDocumentationLinks(config?: RequestConfig): Observable<DocumentationLinks> {
    return this.http.get<DocumentationLinks>(`/api/user/settings/${UserSettingsType.DOC_LINKS}`,
      defaultHttpOptionsFromConfig(config));
  }

  public updateDocumentationLinks(documentationLinks: DocumentationLinks, config?: RequestConfig): Observable<void> {
    return this.http.put<void>(`/api/user/settings/${UserSettingsType.DOC_LINKS}`, documentationLinks,
      defaultHttpOptionsFromConfig(config));
  }

}
