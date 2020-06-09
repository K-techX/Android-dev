package com.udacity.notepad.data

import java.util.Date

class Note {
    var id = -1

    @get:Nullable
    @Nullable
    var text: String? = null
    var isPinned = false
    var createdAt: Date = Date()
    var updatedAt: Date? = null

}