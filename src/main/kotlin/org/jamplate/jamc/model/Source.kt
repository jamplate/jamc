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

import org.jetbrains.annotations.Contract
import java.io.IOException
import java.io.InputStream
import java.io.Reader
import java.io.Serializable

/**
 * TODO
 *
 * @author LSafer
 * @since 0.4.0 ~2022.03.12
 */
abstract class Source : Serializable {
    /**
     * Open a new input-stream that reads the
     * content of this source.
     *
     * @param start how many bytes to skip.
     * @param length how many bytes to read.
     * @return
     * a new input-stream that reads the content
     * of this source
     * @throws IOException if any I/O exception occurs.
     * @since 0.4.0 ~2022.03.12
     */
    @Contract(value = "_,_->new", pure = true)
    abstract fun openInputStream(start: Int = 0, length: Int = -1): InputStream

    /**
     * Open a new reader that reads the content of
     * this source.
     *
     * @param start how many characters to skip.
     * @param length how many characters to read.
     * @return
     * a new reader that reads the content of this
     * source
     * @throws IOException if any I/O exception occurs.
     * @since 0.4.0 ~2022.03.12
     */
    @Contract(value = "_,_->new", pure = true)
    abstract fun openReader(start: Int = 0, length: Int = -1): Reader

    companion object {
        private const val serialVersionUID: Long = 581194514373853967L
    }
}
