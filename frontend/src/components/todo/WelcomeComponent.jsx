import {useParams, Link} from 'react-router-dom'

function WelcomeComponent() {

    const {username } = useParams()

    return (
        <div className="WelcomeComponent">
            <h1>Welcome {username}</h1>
            <div>
                Manage your todos
                <br/> 
                <button className="btn btn-success m-5" >
                    <Link to="/todos" style={{ textDecoration: 'none', color: 'white' }}>
                        Your Todos
                    </Link>
                </button>
            </div>
        </div>
    )
}

export default WelcomeComponent