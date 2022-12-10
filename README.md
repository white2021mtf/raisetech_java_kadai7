# raisetech_Java_課題7提出

授業で扱った実装例を参考にHTTPメソッドの
GET/POST/PATCH/DELETEのリクエストを
扱えるControllerを実装しましょう。

オリジナルの仕様を加えてみましょう。
例）
・http://localhost:8080/names?name=koyama
のようにクエリ文字列を受け取れるようにする
・名前以外にも生年月日を受け取れるよう実装する
・バリデーションについて調べてnameが空文字、null、
20文字以上の場合はエラーとする。
