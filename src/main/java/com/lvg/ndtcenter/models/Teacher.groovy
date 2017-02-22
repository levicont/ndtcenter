package com.lvg.ndtcenter.models

import groovy.transform.Canonical

@Canonical
class Teacher {
    Long id
    String name
    String secondName
    String lastName
    Set<TeacherCertificate> teacherCertificates = []


}
