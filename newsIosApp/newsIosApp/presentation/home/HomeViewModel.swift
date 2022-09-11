//
//  HomeViewModel.swift
//  newsIosApp
//
//  Created by Mohamed on 11/09/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Combine
import shared

class HomeViewModel: ObservableObject {

    @Published var news: [News]

    init() {
        news = []
    }

    func getAllArticles() {
        GetAllArticles(repository: NewsRepositoryImplementation()).run { articles, error in
            if let articles = articles {
                var newsFeed: [News] = []
                for article in articles {
                    newsFeed.append(article as! News)
                }
                self.news = newsFeed
            } else if let error = error {
                self.news = []
            }
        }
    }
}
