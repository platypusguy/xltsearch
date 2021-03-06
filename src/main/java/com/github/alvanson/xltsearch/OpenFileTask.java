/* Copyright 2016 Evan A. Thompson
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.alvanson.xltsearch;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

// desktop.open() must be executed in a separate task
class OpenFileTask extends BaseTask<Void> {
    private final Desktop desktop = Desktop.getDesktop();
    private final File file;

    OpenFileTask(File file) {
        this.file = file;
    }

    @Override
    protected Void call() {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            addMessage(Message.Level.ERROR,
                "Could not open file " + file.getName(), getStackTrace(ex));
        }
        return null;
    }
}
