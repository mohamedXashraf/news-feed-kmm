//
//  DetailsView.swift
//  newsIosApp
//
//  Created by Mohamed on 11/09/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct DetailsView: View {

    var article: News?

    var body: some View {
        ScrollView (.vertical, showsIndicators: false) {
            VStack {
                AsyncImage(url: URL(string: article?.urlToImage ?? ""), content: { phase in
                    switch phase {
                    case .success(let image):
                        image.resizable().aspectRatio(contentMode: .fill).frame(maxHeight: 300).cornerRadius(10)
                    default:
                        Spacer()
                    }
                })
                VStack(alignment: .leading) {
                    Text(article?.title ?? "").font(.title).fontWeight(.bold).foregroundColor(Color.black)
                    Text("By \(article?.author ?? "")").font(.footnote).foregroundColor(Color.black)
                    Spacer()
                    Spacer()
                    Spacer()
                    Text(article?.description_ ?? "").font(.body).foregroundColor(Color.black)
                }
                Spacer()
                Spacer()
                Spacer()
                Button(action: {
                    if article != nil, article?.url != nil {
                        print("open link")
                        UIApplication.shared.open(URL(string: article?.url ?? "")!)
                    }
                }) {
                    Spacer()
                    Text("Open Website").padding(EdgeInsets.init(top: 10, leading: 0, bottom: 10, trailing: 0)).foregroundColor(Color.white)
                    Spacer()
                }.background(Color.black).buttonStyle(.bordered).frame(maxWidth: .infinity)
            }.padding()
        }.frame(
            minWidth: 0,
            maxWidth: .infinity,
            minHeight: 0,
            maxHeight: .infinity,
            alignment: .top
        )
    }
}

struct DetailsView_Previews: PreviewProvider {
    static var previews: some View {
        DetailsView()
    }
}
