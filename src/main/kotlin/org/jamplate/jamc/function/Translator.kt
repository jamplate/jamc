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

// Mirror -> Instruction

/**
 * A class holding the arguments of a translator.
 *
 * @author LSafer
 * @since 0.4.0 ~2022.03.12
 */
data class TranslatorArgument(
    /**
     * The parent translator.
     *
     * @since 0.4.0 ~2022.03.12
     */
    val parent: Formatter,
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
     * The mirror to generate an instruction for.
     *
     * @since 0.4.0 ~2022.03.12
     */
    val mirror: Mirror
)

/**
 * A class holding the result of a translator invocation.
 *
 * @author LSafer
 * @since 0.4.0 ~2022.03.12
 */
data class TranslatorResult(
    /**
     * The generated instruction.
     *
     * @since 0.4.0 ~2022.03.12
     */
    val instruction: Instruction? = null,
    /**
     * The messages from the translator if any.
     *
     * @since 0.4.0 ~2022.03.12
     */
    val messages: List<Message> = emptyList()
)

/**
 * A function that generates instructions from mirrors.
 *
 * @author LSafer
 * @since 0.4.0 ~2022.03.12
 */
fun interface Translator {
    /**
     * Invoke this translator.
     *
     * @param argument the translator argument.
     * @throws Throwable
     * when an unexpected (fetal/internal) exception
     * occurs. And the processing must stop due to that.
     * @since 0.4.0 ~2022.03.12
     */
    operator fun invoke(argument: TranslatorArgument): TranslatorResult

    /**
     * A translator that does nothing.
     *
     * @since 0.4.0 ~2022.03.13
     */
    companion object : Translator {
        override fun invoke(argument: TranslatorArgument): TranslatorResult =
            TranslatorResult()
    }
}
