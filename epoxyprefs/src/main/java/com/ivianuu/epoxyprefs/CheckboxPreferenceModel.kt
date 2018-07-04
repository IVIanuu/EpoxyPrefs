/*
 * Copyright 2018 Manuel Wrage
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ivianuu.epoxyprefs

import android.content.Context
import android.widget.CompoundButton
import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.EpoxyModelClass
import kotlinx.android.synthetic.main.widget_preference_checkbox.*

/**
 * A check box preference
 */
@EpoxyModelClass
abstract class CheckboxPreferenceModel(context: Context) :
    CompoundButtonPreferenceModel(context) {

    override val Holder.compoundButton: CompoundButton?
        get() = checkbox

    init {
        widgetLayoutRes = R.layout.widget_preference_checkbox
    }

    open class Builder(override val model: CheckboxPreferenceModel) :
        CompoundButtonPreferenceModel.Builder(model)
}

inline fun EpoxyController.checkboxPreference(
    context: Context,
    init: CheckboxPreferenceModel.Builder.() -> Unit
) {
    val model = CheckboxPreferenceModel_(context)
    init.invoke(CheckboxPreferenceModel.Builder(model))
    model.addTo(this)
}

inline fun PreferenceEpoxyController.checkboxPreference(
    init: CheckboxPreferenceModel.Builder.() -> Unit
) {
    checkboxPreference(context, init)
}