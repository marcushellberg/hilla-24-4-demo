import {NavLink, Outlet} from "react-router-dom";
import './styles.css'

export default function Layout() {
  return (
    <div className="flex flex-col h-full">
      <nav className="p-m flex gap-s items-baseline">
        <h1 className="text-l">Hilla app</h1>
        <NavLink to="/">Contacts</NavLink>
        <NavLink to="/chat">Chat</NavLink>
      </nav>
      <Outlet/>
    </div>
  );
};