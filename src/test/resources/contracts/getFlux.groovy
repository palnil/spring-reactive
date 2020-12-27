import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return flux endpoint"
    request {
        method GET()
        url("/flux")
    }
    response {
        status 200
    }
}