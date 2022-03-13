/*
 *	Copyright 2022 cufy.org
 *
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *
 *	    http://www.apache.org/licenses/LICENSE-2.0
 *
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */
package org.jamplate.jamc

import org.jamplate.jamtree.Tree

// Tree<Token> -> Set<Tree<Token>>

/**
 * A class holding the arguments of a lexer.
 *
 * @author LSafer
 * @since 0.4.0 ~2022.03.12
 */
data class LexerArgument(
    /**
     * The parent lexer.
     *
     * @since 0.4.0 ~2022.03.12
     */
    val parent: Lexer,
    /**
     * The ambient compilation.
     *
     * @since 0.4.0 ~2022.03.12
     */
    val compilation: Compilation,
    /**
     * The module.
     *
     * @since 0.4.0 ~2022.03.12
     */
    val module: Module,
    /**
     * The tree to generate trees from.
     *
     * @since 0.4.0 ~2022.03.12
     */
    val tree: Tree<Token>
)

/**
 * A class holding the result of a lexer invocation.
 *
 * @author LSafer
 * @since 0.4.0 ~2022.03.12
 */
data class LexerResult(
    /**
     * The generated trees.
     *
     * @since 0.4.0 ~2022.03.12
     */
    val trees: Set<Tree<Token>> = emptySet(),
    /**
     * The messages from the lexer if any.
     *
     * @since 0.4.0 ~2022.03.12
     */
    val messages: List<Message> = emptyList()
)

/**
 * A function that generates trees from source-code.
 *
 * @author LSafer
 * @since 0.4.0 ~2022.03.12
 */
fun interface Lexer {
    /**
     * Invoke this lexer.
     *
     * @param argument the lexer argument.
     * @throws Throwable
     * when an unexpected (fetal/internal) exception
     * occurs. And the processing must stop due to that.
     * @since 0.4.0 ~2022.03.12
     */
    operator fun invoke(argument: LexerArgument): LexerResult

    /**
     * A lexer that does nothing.
     *
     * @since 0.4.0 ~2022.03.12
     */
    companion object : Lexer {
        override fun invoke(argument: LexerArgument): LexerResult =
            LexerResult()
    }
}
