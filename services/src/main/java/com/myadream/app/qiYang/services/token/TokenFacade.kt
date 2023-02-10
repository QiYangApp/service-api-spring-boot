package com.myadream.app.qiYang.services.token

import com.myadream.app.qiYang.services.token.enums.TokenType

interface TokenFacade {
    fun setTokenType(token: TokenType): TokenFacade;

    fun generate(dataSet: TokenDataSet): String;
}