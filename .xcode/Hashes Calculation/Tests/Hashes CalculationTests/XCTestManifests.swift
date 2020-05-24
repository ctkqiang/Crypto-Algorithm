import XCTest

#if !canImport(ObjectiveC)
public func allTests() -> [XCTestCaseEntry] {
    return [
        testCase(Hashes_CalculationTests.allTests),
    ]
}
#endif
