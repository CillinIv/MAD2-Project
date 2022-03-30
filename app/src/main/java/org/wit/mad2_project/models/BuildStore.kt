package org.wit.mad2_project.models

interface BuildStore {
    fun findAll() : List<BuildModel>
    fun findById(id: Long) : BuildModel?
    fun create(build: BuildModel)
}