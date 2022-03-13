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

// Mirror -> Tree<Token>

/**
 * A class holding the arguments of a generator.
 *
 * @author LSafer
 * @since 0.4.0 ~2022.03.12
 */
data class GeneratorArgument(
    /**
     * The parent generator.
     *
     * @since 0.4.0 ~2022.03.12
     */
    val parent: Generator,
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
     * The mirror to generate a token for.
     *
     * @since 0.4.0 ~2022.03.12
     */
    val mirror: Mirror
)

/**
 * A class holding the result of a generator invocation.
 *
 * @author LSafer
 * @since 0.4.0 ~2022.03.12
 */
data class GeneratorResult(
    /**
     * The generated token tree.
     *
     * @since 0.4.0 ~2022.03.12
     */
    val tree: Tree<Token>? = null,
    /**
     * The messages from the formatter if any.
     *
     * @since 0.4.0 ~2022.03.12
     */
    val messages: List<Message> = emptyList()
)

/**
 * A function that generate tokens from mirrors.
 *
 * @author LSafer
 * @since 0.4.0 ~2022.03.12
 */
fun interface Generator {
    /**
     * Invoke this generator.
     *
     * @param argument the generator argument.
     * @throws Throwable
     * when an unexpected (fetal/internal) exception
     * occurs. And the processing must stop due to that.
     * @since 0.4.0 ~2022.03.12
     */
    operator fun invoke(argument: GeneratorArgument): GeneratorResult

    /**
     * A generator that does nothing.
     *
     * @since 0.4.0 ~2022.03.12
     */
    companion object : Generator {
        override fun invoke(argument: GeneratorArgument): GeneratorResult =
            GeneratorResult()
    }
}
