/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.LocalContentColor
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle

@Composable
fun Temperature(
    text: String,
    modifier: Modifier = Modifier,
    isDrawable: Boolean = false,
    isSunInfo: Boolean = false,
    painter: @Composable () -> Unit,
    color: Color = LocalContentColor.current,
    style: TextStyle = LocalTextStyle.current
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (isDrawable) {
            painter()
        }
        if (isSunInfo) {
            Text(
                text = buildAnnotatedString {
                    append(text = text)
                },
                color = color,
                style = style,
                modifier = modifier
            )
        } else {
            Text(
                text = buildAnnotatedString {
                    append(text = text)
                    withStyle(SpanStyle(baselineShift = BaselineShift.None)) {
                        append("\u00B0")
                    }
                },
                color = color,
                style = style,
                modifier = modifier
            )
        }
    }
}
