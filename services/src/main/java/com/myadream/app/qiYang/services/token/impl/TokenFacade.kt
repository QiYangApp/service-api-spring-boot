package com.myadream.app.qiYang.services.token.impl

import com.myadream.app.qiYang.services.token.TokenDataSet
import com.myadream.app.qiYang.services.token.TokenFacade
import com.myadream.app.qiYang.services.token.enums.TokenType
import org.springframework.stereotype.Service

@Service
class TokenFacadeImpl: TokenFacade {
    override fun setTokenType(token: TokenType): TokenFacade {
        TODO("Not yet implemented")
    }

    override fun generate(dataSet: TokenDataSet): String {
        TODO("Not yet implemented")
    }
}