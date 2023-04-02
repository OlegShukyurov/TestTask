
class AssociativeArray {

    private AssociativeArray() {}

    static getAssociativeArray(List elements) {
        if (elements == null || elements.isEmpty()) {
            throw RuntimeException
        }
        def result = [:]
        elements.each {result.merge(it, 1, Integer::sum)}
        result
    }
}
