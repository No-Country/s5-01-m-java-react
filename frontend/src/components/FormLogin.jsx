import { useRef, useState, useEffect, useContext } from "react";
import logo from '../assets/img/LOGO.png'
import '../pages/login/login.css';
import BtnRed from "./buttons/BtnRed";
import axios from "axios";
import { NavLink } from 'react-router-dom'
import { setUserData } from '../store/slices/user/index'
import { useDispatch } from 'react-redux'

const baseURL = 'https://s5-01-m-java-react-production.up.railway.app/auth/login'



export default function FormLogin() {

    const userRef = useRef();
    const errRef = useRef();
    const [user, setUser] = useState("");
    const [pwd, setPwd] = useState("");
    const [errMsg, setErrMsg] = useState("");
    const [success, setSuccess] = useState(false);

    useEffect(() => {
        userRef.current.focus();
    }, []);

    useEffect(() => {
        setErrMsg("");
    }, [user, pwd]);
    
    const dispatch = useDispatch()
    const handleSubmit = async (e) =>  {
        console.log("funcioPost")
      
        e.preventDefault();
        try {
            axios.post(baseURL, {
                "email": user,
                "password": pwd
            })
                .then(function (response) {
                    // console.log(response.data.username);
                    dispatch(setUserData(response.data))
                    setUser("");
                    setPwd("");
                    setSuccess(true);
                })
                .catch(function (err) {
                    if (!err?.response) {
                        setErrMsg("No Server Response");
                    } else if (err.response?.status === 400) {
                        setErrMsg("Missing Username or Password");
                    } else if (err.response?.status === 401) {
                        setErrMsg("Unauthorized");
                    } else {
                        setErrMsg("Datos incorrectos");
                    }
                    errRef.current.focus();
                });


        } catch (error) {
           console.log(error)
        }
    };






    return (
        <>
            {success ? (
                <section className="d-flex flex-column align-items-center mt-5">
                    <h1 className="text-white">Bienvenido a 4JUNIORS!!</h1>
                    <NavLink to="/home" className="text-danger">Ir al inicio</NavLink>
                </section>
            ) : (

                <div className="containerLogin">


                    <div>
                        <img src={logo} alt="Logo" className="imageLogo" />
                    </div>

                    <div>
                        <p className="textLogin">¿De vuelta por aquí?</p>
                        <p className="data">Ingresa con tus datos.</p>
                    </div>

                    <form onSubmit={handleSubmit}>
                        <div className="containerForm">
                            <label htmlFor="">e-mail</label>
                            <input
                                type="email"
                                className="margin"
                                placeholder="johndoe@gmail.com"
                                id="username"
                                ref={userRef}
                                autoComplete="off"
                                onChange={(e) => setUser(e.target.value)}
                                value={user}
                                required />
                            <label htmlFor="">contraseña</label>
                            <input
                                type="password"
                                id="password"
                                onChange={(e) => setPwd(e.target.value)}
                                value={pwd}
                                required />
                            <div className="passwordLogin">
                                <p>¿Perdiste tu contraseña?</p>
                                <a href="#">TOCA AQUI</a>
                            </div>

                            <div className='btnRed'>
                                <BtnRed label='INGRESAR' color='#F62223' width='140px' type={'submit'} />
                            </div>
                            <p
                                ref={errRef}
                                className={'text-center text-danger'}
                                aria-live="assertive"
                            >
                                {errMsg}
                            </p>
                        </div>
                    </form>

                </div>
            )}
        </>
    )
}